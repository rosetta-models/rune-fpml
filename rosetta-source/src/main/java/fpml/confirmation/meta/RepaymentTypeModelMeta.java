package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RepaymentTypeModel;
import fpml.confirmation.validation.RepaymentTypeModelTypeFormatValidator;
import fpml.confirmation.validation.RepaymentTypeModelValidator;
import fpml.confirmation.validation.exists.RepaymentTypeModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RepaymentTypeModel.class)
public class RepaymentTypeModelMeta implements RosettaMetaData<RepaymentTypeModel> {

	@Override
	public List<Validator<? super RepaymentTypeModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RepaymentTypeModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RepaymentTypeModel> validator() {
		return new RepaymentTypeModelValidator();
	}

	@Override
	public Validator<? super RepaymentTypeModel> typeFormatValidator() {
		return new RepaymentTypeModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RepaymentTypeModel, Set<String>> onlyExistsValidator() {
		return new RepaymentTypeModelOnlyExistsValidator();
	}
}
