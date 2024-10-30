package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestRetransmission;
import fpml.confirmation.validation.RequestRetransmissionTypeFormatValidator;
import fpml.confirmation.validation.RequestRetransmissionValidator;
import fpml.confirmation.validation.exists.RequestRetransmissionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RequestRetransmission.class)
public class RequestRetransmissionMeta implements RosettaMetaData<RequestRetransmission> {

	@Override
	public List<Validator<? super RequestRetransmission>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestRetransmission, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestRetransmission> validator() {
		return new RequestRetransmissionValidator();
	}

	@Override
	public Validator<? super RequestRetransmission> typeFormatValidator() {
		return new RequestRetransmissionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestRetransmission, Set<String>> onlyExistsValidator() {
		return new RequestRetransmissionOnlyExistsValidator();
	}
}
