package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TaxWithholding;
import fpml.confirmation.validation.TaxWithholdingTypeFormatValidator;
import fpml.confirmation.validation.TaxWithholdingValidator;
import fpml.confirmation.validation.exists.TaxWithholdingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TaxWithholding.class)
public class TaxWithholdingMeta implements RosettaMetaData<TaxWithholding> {

	@Override
	public List<Validator<? super TaxWithholding>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TaxWithholding, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TaxWithholding> validator() {
		return new TaxWithholdingValidator();
	}

	@Override
	public Validator<? super TaxWithholding> typeFormatValidator() {
		return new TaxWithholdingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TaxWithholding, Set<String>> onlyExistsValidator() {
		return new TaxWithholdingOnlyExistsValidator();
	}
}
