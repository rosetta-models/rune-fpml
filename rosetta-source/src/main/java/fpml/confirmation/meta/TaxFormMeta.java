package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TaxForm;
import fpml.confirmation.validation.TaxFormTypeFormatValidator;
import fpml.confirmation.validation.TaxFormValidator;
import fpml.confirmation.validation.exists.TaxFormOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TaxForm.class)
public class TaxFormMeta implements RosettaMetaData<TaxForm> {

	@Override
	public List<Validator<? super TaxForm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TaxForm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TaxForm> validator() {
		return new TaxFormValidator();
	}

	@Override
	public Validator<? super TaxForm> typeFormatValidator() {
		return new TaxFormTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TaxForm, Set<String>> onlyExistsValidator() {
		return new TaxFormOnlyExistsValidator();
	}
}
