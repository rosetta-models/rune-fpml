package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FloatingRateIndexModel;
import fpml.confirmation.validation.FloatingRateIndexModelTypeFormatValidator;
import fpml.confirmation.validation.FloatingRateIndexModelValidator;
import fpml.confirmation.validation.exists.FloatingRateIndexModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FloatingRateIndexModel.class)
public class FloatingRateIndexModelMeta implements RosettaMetaData<FloatingRateIndexModel> {

	@Override
	public List<Validator<? super FloatingRateIndexModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateIndexModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FloatingRateIndexModel> validator() {
		return new FloatingRateIndexModelValidator();
	}

	@Override
	public Validator<? super FloatingRateIndexModel> typeFormatValidator() {
		return new FloatingRateIndexModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateIndexModel, Set<String>> onlyExistsValidator() {
		return new FloatingRateIndexModelOnlyExistsValidator();
	}
}
