package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StubFloatingRateIndexModel;
import fpml.confirmation.validation.StubFloatingRateIndexModelTypeFormatValidator;
import fpml.confirmation.validation.StubFloatingRateIndexModelValidator;
import fpml.confirmation.validation.exists.StubFloatingRateIndexModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=StubFloatingRateIndexModel.class)
public class StubFloatingRateIndexModelMeta implements RosettaMetaData<StubFloatingRateIndexModel> {

	@Override
	public List<Validator<? super StubFloatingRateIndexModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StubFloatingRateIndexModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StubFloatingRateIndexModel> validator() {
		return new StubFloatingRateIndexModelValidator();
	}

	@Override
	public Validator<? super StubFloatingRateIndexModel> typeFormatValidator() {
		return new StubFloatingRateIndexModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StubFloatingRateIndexModel, Set<String>> onlyExistsValidator() {
		return new StubFloatingRateIndexModelOnlyExistsValidator();
	}
}
