package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.validation.ResponseMessageHeaderTypeFormatValidator;
import fpml.confirmation.validation.ResponseMessageHeaderValidator;
import fpml.confirmation.validation.exists.ResponseMessageHeaderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ResponseMessageHeader.class)
public class ResponseMessageHeaderMeta implements RosettaMetaData<ResponseMessageHeader> {

	@Override
	public List<Validator<? super ResponseMessageHeader>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResponseMessageHeader, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ResponseMessageHeader> validator() {
		return new ResponseMessageHeaderValidator();
	}

	@Override
	public Validator<? super ResponseMessageHeader> typeFormatValidator() {
		return new ResponseMessageHeaderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResponseMessageHeader, Set<String>> onlyExistsValidator() {
		return new ResponseMessageHeaderOnlyExistsValidator();
	}
}
