package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.validation.OptionSettlementModelTypeFormatValidator;
import fpml.confirmation.validation.OptionSettlementModelValidator;
import fpml.confirmation.validation.exists.OptionSettlementModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionSettlementModel.class)
public class OptionSettlementModelMeta implements RosettaMetaData<OptionSettlementModel> {

	@Override
	public List<Validator<? super OptionSettlementModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionSettlementModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionSettlementModel> validator() {
		return new OptionSettlementModelValidator();
	}

	@Override
	public Validator<? super OptionSettlementModel> typeFormatValidator() {
		return new OptionSettlementModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionSettlementModel, Set<String>> onlyExistsValidator() {
		return new OptionSettlementModelOnlyExistsValidator();
	}
}
