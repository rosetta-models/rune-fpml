package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalStandardQuality;
import fpml.confirmation.validation.CoalStandardQualityTypeFormatValidator;
import fpml.confirmation.validation.CoalStandardQualityValidator;
import fpml.confirmation.validation.exists.CoalStandardQualityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CoalStandardQuality.class)
public class CoalStandardQualityMeta implements RosettaMetaData<CoalStandardQuality> {

	@Override
	public List<Validator<? super CoalStandardQuality>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalStandardQuality, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalStandardQuality> validator() {
		return new CoalStandardQualityValidator();
	}

	@Override
	public Validator<? super CoalStandardQuality> typeFormatValidator() {
		return new CoalStandardQualityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalStandardQuality, Set<String>> onlyExistsValidator() {
		return new CoalStandardQualityOnlyExistsValidator();
	}
}
