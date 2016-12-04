package ru.sbrf.socialnetwork.loginservice.controller;

import org.junit.Test;
import ru.sbrf.socialnetwork.commons.model.account.AccessToken;
import ru.sbrf.socialnetwork.commons.responses.Response;
import ru.sbrf.socialnetwork.loginservice.domain.objects.CheckToken;
import ru.sbrf.socialnetwork.loginservice.repository.AccessTokenRepository;
import ru.sbrf.socialnetwork.loginservice.repository.criteria.AccessTokenCriteriaFactory;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by Ivan on 04/12/2016.
 */
public class MainControllerTest {
    @Test
    public void checkTokenResponseFalse() throws Exception {
        AccessTokenRepository repository = mock(AccessTokenRepository.class);
        AccessTokenCriteriaFactory factory = mock(AccessTokenCriteriaFactory.class);

        when(repository.select(any())).thenReturn(Collections.emptyList());
        when(repository.selectFirstRemoveIfInvalid(any(), any())).thenReturn(Optional.empty());

        MainController controller = new MainController(
                null, null,
                repository,
                null, null, null, factory
        );

        Response<?> response = controller.checkToken(new CheckToken());

        assertTrue(response.getStatus().equals("ok"));
        assertTrue(response.getObject().getClass() == boolean.class
                || response.getObject().getClass() == Boolean.class);

        boolean value = (boolean) ((Object) response.getObject());

        assertFalse(value);
    }

    @Test
    public void checkTokenResponseTrue() throws Exception {
        AccessTokenRepository repository = mock(AccessTokenRepository.class);
        AccessTokenCriteriaFactory factory = mock(AccessTokenCriteriaFactory.class);

        when(repository.select(any())).thenReturn(Collections.singletonList(
                new AccessToken(1, "123", LocalDateTime.now()))
        );
        when(repository.selectFirstRemoveIfInvalid(any(), any())).thenReturn(Optional.of(new AccessToken(0, null, null)));

        MainController controller = new MainController(
                null, null,
                repository,
                null, null, null, factory
        );

        Response<?> response = controller.checkToken(new CheckToken());

        assertTrue(response.getStatus().equals("ok"));
        assertTrue(response.getObject().getClass() == boolean.class
                || response.getObject().getClass() == Boolean.class);

        Boolean value = (Boolean) response.getObject();

        assertTrue(value);
    }


}