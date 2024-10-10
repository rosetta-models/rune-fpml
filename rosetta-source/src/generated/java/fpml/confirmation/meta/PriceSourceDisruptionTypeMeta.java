package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PriceSourceDisruptionType;
import fpml.confirmation.validation.PriceSourceDisruptionTypeTypeFormatValidator;
import fpml.confirmation.validation.PriceSourceDisruptionTypeValidator;
import fpml.confirmation.validation.exists.PriceSourceDisruptionTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PriceSourceDisruptionType.class)
public class PriceSourceDisruptionTypeMeta implements RosettaMetaData<PriceSourceDisruptionType> {

	@Override
	public List<Validator<? super PriceSourceDisruptionType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PriceSourceDisruptionType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PriceSourceDisruptionType> validator() {
		return new PriceSourceDisruptionTypeValidator();
	}

	@Override
	public Validator<? super PriceSourceDisruptionType> typeFormatValidator() {
		return new PriceSourceDisruptionTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceSourceDisruptionType, Set<String>> onlyExistsValidator() {
		return new PriceSourceDisruptionTypeOnlyExistsValidator();
	}
}
