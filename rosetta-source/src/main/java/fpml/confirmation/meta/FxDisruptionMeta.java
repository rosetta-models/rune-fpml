package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxDisruption;
import fpml.confirmation.validation.FxDisruptionTypeFormatValidator;
import fpml.confirmation.validation.FxDisruptionValidator;
import fpml.confirmation.validation.exists.FxDisruptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxDisruption.class)
public class FxDisruptionMeta implements RosettaMetaData<FxDisruption> {

	@Override
	public List<Validator<? super FxDisruption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDisruption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxDisruption> validator() {
		return new FxDisruptionValidator();
	}

	@Override
	public Validator<? super FxDisruption> typeFormatValidator() {
		return new FxDisruptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDisruption, Set<String>> onlyExistsValidator() {
		return new FxDisruptionOnlyExistsValidator();
	}
}
