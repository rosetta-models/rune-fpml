package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.validation.RequestMessageHeaderTypeFormatValidator;
import fpml.confirmation.validation.RequestMessageHeaderValidator;
import fpml.confirmation.validation.exists.RequestMessageHeaderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RequestMessageHeader.class)
public class RequestMessageHeaderMeta implements RosettaMetaData<RequestMessageHeader> {

	@Override
	public List<Validator<? super RequestMessageHeader>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestMessageHeader, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestMessageHeader> validator() {
		return new RequestMessageHeaderValidator();
	}

	@Override
	public Validator<? super RequestMessageHeader> typeFormatValidator() {
		return new RequestMessageHeaderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestMessageHeader, Set<String>> onlyExistsValidator() {
		return new RequestMessageHeaderOnlyExistsValidator();
	}
}
