package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PriceModel;
import fpml.confirmation.validation.PriceModelTypeFormatValidator;
import fpml.confirmation.validation.PriceModelValidator;
import fpml.confirmation.validation.exists.PriceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PriceModel.class)
public class PriceModelMeta implements RosettaMetaData<PriceModel> {

	@Override
	public List<Validator<? super PriceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PriceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PriceModel> validator() {
		return new PriceModelValidator();
	}

	@Override
	public Validator<? super PriceModel> typeFormatValidator() {
		return new PriceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceModel, Set<String>> onlyExistsValidator() {
		return new PriceModelOnlyExistsValidator();
	}
}
