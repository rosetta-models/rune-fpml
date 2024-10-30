package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SupervisoryBody;
import fpml.confirmation.validation.SupervisoryBodyTypeFormatValidator;
import fpml.confirmation.validation.SupervisoryBodyValidator;
import fpml.confirmation.validation.exists.SupervisoryBodyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SupervisoryBody.class)
public class SupervisoryBodyMeta implements RosettaMetaData<SupervisoryBody> {

	@Override
	public List<Validator<? super SupervisoryBody>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SupervisoryBody, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SupervisoryBody> validator() {
		return new SupervisoryBodyValidator();
	}

	@Override
	public Validator<? super SupervisoryBody> typeFormatValidator() {
		return new SupervisoryBodyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SupervisoryBody, Set<String>> onlyExistsValidator() {
		return new SupervisoryBodyOnlyExistsValidator();
	}
}
