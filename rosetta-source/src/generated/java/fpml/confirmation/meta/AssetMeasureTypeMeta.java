package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetMeasureType;
import fpml.confirmation.validation.AssetMeasureTypeTypeFormatValidator;
import fpml.confirmation.validation.AssetMeasureTypeValidator;
import fpml.confirmation.validation.exists.AssetMeasureTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetMeasureType.class)
public class AssetMeasureTypeMeta implements RosettaMetaData<AssetMeasureType> {

	@Override
	public List<Validator<? super AssetMeasureType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetMeasureType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AssetMeasureType> validator() {
		return new AssetMeasureTypeValidator();
	}

	@Override
	public Validator<? super AssetMeasureType> typeFormatValidator() {
		return new AssetMeasureTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetMeasureType, Set<String>> onlyExistsValidator() {
		return new AssetMeasureTypeOnlyExistsValidator();
	}
}
