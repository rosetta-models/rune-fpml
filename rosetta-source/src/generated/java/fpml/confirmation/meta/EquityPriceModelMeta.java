package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityPriceModel;
import fpml.confirmation.validation.EquityPriceModelTypeFormatValidator;
import fpml.confirmation.validation.EquityPriceModelValidator;
import fpml.confirmation.validation.exists.EquityPriceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EquityPriceModel.class)
public class EquityPriceModelMeta implements RosettaMetaData<EquityPriceModel> {

	@Override
	public List<Validator<? super EquityPriceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityPriceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityPriceModel> validator() {
		return new EquityPriceModelValidator();
	}

	@Override
	public Validator<? super EquityPriceModel> typeFormatValidator() {
		return new EquityPriceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityPriceModel, Set<String>> onlyExistsValidator() {
		return new EquityPriceModelOnlyExistsValidator();
	}
}
