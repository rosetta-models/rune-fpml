package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FormulaComponent;
import fpml.confirmation.validation.FormulaComponentTypeFormatValidator;
import fpml.confirmation.validation.FormulaComponentValidator;
import fpml.confirmation.validation.exists.FormulaComponentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FormulaComponent.class)
public class FormulaComponentMeta implements RosettaMetaData<FormulaComponent> {

	@Override
	public List<Validator<? super FormulaComponent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FormulaComponent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FormulaComponent> validator() {
		return new FormulaComponentValidator();
	}

	@Override
	public Validator<? super FormulaComponent> typeFormatValidator() {
		return new FormulaComponentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FormulaComponent, Set<String>> onlyExistsValidator() {
		return new FormulaComponentOnlyExistsValidator();
	}
}
