package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxCrossRateObservable;
import fpml.confirmation.validation.FxCrossRateObservableTypeFormatValidator;
import fpml.confirmation.validation.FxCrossRateObservableValidator;
import fpml.confirmation.validation.exists.FxCrossRateObservableOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxCrossRateObservable.class)
public class FxCrossRateObservableMeta implements RosettaMetaData<FxCrossRateObservable> {

	@Override
	public List<Validator<? super FxCrossRateObservable>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxCrossRateObservable, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxCrossRateObservable> validator() {
		return new FxCrossRateObservableValidator();
	}

	@Override
	public Validator<? super FxCrossRateObservable> typeFormatValidator() {
		return new FxCrossRateObservableTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxCrossRateObservable, Set<String>> onlyExistsValidator() {
		return new FxCrossRateObservableOnlyExistsValidator();
	}
}
