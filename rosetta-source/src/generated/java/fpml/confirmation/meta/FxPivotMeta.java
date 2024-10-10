package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxPivot;
import fpml.confirmation.validation.FxPivotTypeFormatValidator;
import fpml.confirmation.validation.FxPivotValidator;
import fpml.confirmation.validation.exists.FxPivotOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxPivot.class)
public class FxPivotMeta implements RosettaMetaData<FxPivot> {

	@Override
	public List<Validator<? super FxPivot>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxPivot, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxPivot> validator() {
		return new FxPivotValidator();
	}

	@Override
	public Validator<? super FxPivot> typeFormatValidator() {
		return new FxPivotTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxPivot, Set<String>> onlyExistsValidator() {
		return new FxPivotOnlyExistsValidator();
	}
}
