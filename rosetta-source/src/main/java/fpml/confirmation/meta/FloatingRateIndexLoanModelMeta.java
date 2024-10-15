package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FloatingRateIndexLoanModel;
import fpml.confirmation.validation.FloatingRateIndexLoanModelTypeFormatValidator;
import fpml.confirmation.validation.FloatingRateIndexLoanModelValidator;
import fpml.confirmation.validation.exists.FloatingRateIndexLoanModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FloatingRateIndexLoanModel.class)
public class FloatingRateIndexLoanModelMeta implements RosettaMetaData<FloatingRateIndexLoanModel> {

	@Override
	public List<Validator<? super FloatingRateIndexLoanModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateIndexLoanModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FloatingRateIndexLoanModel> validator() {
		return new FloatingRateIndexLoanModelValidator();
	}

	@Override
	public Validator<? super FloatingRateIndexLoanModel> typeFormatValidator() {
		return new FloatingRateIndexLoanModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateIndexLoanModel, Set<String>> onlyExistsValidator() {
		return new FloatingRateIndexLoanModelOnlyExistsValidator();
	}
}
