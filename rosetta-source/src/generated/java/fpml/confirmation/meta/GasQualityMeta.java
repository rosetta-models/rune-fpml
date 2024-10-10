package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GasQuality;
import fpml.confirmation.validation.GasQualityTypeFormatValidator;
import fpml.confirmation.validation.GasQualityValidator;
import fpml.confirmation.validation.exists.GasQualityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GasQuality.class)
public class GasQualityMeta implements RosettaMetaData<GasQuality> {

	@Override
	public List<Validator<? super GasQuality>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GasQuality, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GasQuality> validator() {
		return new GasQualityValidator();
	}

	@Override
	public Validator<? super GasQuality> typeFormatValidator() {
		return new GasQualityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasQuality, Set<String>> onlyExistsValidator() {
		return new GasQualityOnlyExistsValidator();
	}
}
