package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxRateObservable;
import fpml.confirmation.validation.FxRateObservableTypeFormatValidator;
import fpml.confirmation.validation.FxRateObservableValidator;
import fpml.confirmation.validation.exists.FxRateObservableOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxRateObservable.class)
public class FxRateObservableMeta implements RosettaMetaData<FxRateObservable> {

	@Override
	public List<Validator<? super FxRateObservable>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxRateObservable>create(fpml.confirmation.validation.datarule.FxRateObservableChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxRateObservable, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxRateObservable> validator() {
		return new FxRateObservableValidator();
	}

	@Override
	public Validator<? super FxRateObservable> typeFormatValidator() {
		return new FxRateObservableTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxRateObservable, Set<String>> onlyExistsValidator() {
		return new FxRateObservableOnlyExistsValidator();
	}
}
