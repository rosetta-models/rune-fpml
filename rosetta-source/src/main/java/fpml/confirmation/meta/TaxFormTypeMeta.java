package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TaxFormType;
import fpml.confirmation.validation.TaxFormTypeTypeFormatValidator;
import fpml.confirmation.validation.TaxFormTypeValidator;
import fpml.confirmation.validation.exists.TaxFormTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TaxFormType.class)
public class TaxFormTypeMeta implements RosettaMetaData<TaxFormType> {

	@Override
	public List<Validator<? super TaxFormType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TaxFormType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TaxFormType> validator() {
		return new TaxFormTypeValidator();
	}

	@Override
	public Validator<? super TaxFormType> typeFormatValidator() {
		return new TaxFormTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TaxFormType, Set<String>> onlyExistsValidator() {
		return new TaxFormTypeOnlyExistsValidator();
	}
}
