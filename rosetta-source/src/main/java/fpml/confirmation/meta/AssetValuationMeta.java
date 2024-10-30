package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetValuation;
import fpml.confirmation.validation.AssetValuationTypeFormatValidator;
import fpml.confirmation.validation.AssetValuationValidator;
import fpml.confirmation.validation.exists.AssetValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AssetValuation.class)
public class AssetValuationMeta implements RosettaMetaData<AssetValuation> {

	@Override
	public List<Validator<? super AssetValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AssetValuation> validator() {
		return new AssetValuationValidator();
	}

	@Override
	public Validator<? super AssetValuation> typeFormatValidator() {
		return new AssetValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetValuation, Set<String>> onlyExistsValidator() {
		return new AssetValuationOnlyExistsValidator();
	}
}
