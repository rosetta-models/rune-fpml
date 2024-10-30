package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CollateralizationType;
import fpml.confirmation.validation.CollateralizationTypeTypeFormatValidator;
import fpml.confirmation.validation.CollateralizationTypeValidator;
import fpml.confirmation.validation.exists.CollateralizationTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CollateralizationType.class)
public class CollateralizationTypeMeta implements RosettaMetaData<CollateralizationType> {

	@Override
	public List<Validator<? super CollateralizationType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralizationType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CollateralizationType> validator() {
		return new CollateralizationTypeValidator();
	}

	@Override
	public Validator<? super CollateralizationType> typeFormatValidator() {
		return new CollateralizationTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralizationType, Set<String>> onlyExistsValidator() {
		return new CollateralizationTypeOnlyExistsValidator();
	}
}
