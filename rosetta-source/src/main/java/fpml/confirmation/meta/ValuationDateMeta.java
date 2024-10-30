package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ValuationDate;
import fpml.confirmation.validation.ValuationDateTypeFormatValidator;
import fpml.confirmation.validation.ValuationDateValidator;
import fpml.confirmation.validation.exists.ValuationDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ValuationDate.class)
public class ValuationDateMeta implements RosettaMetaData<ValuationDate> {

	@Override
	public List<Validator<? super ValuationDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ValuationDate>create(fpml.confirmation.validation.datarule.ValuationDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ValuationDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ValuationDate> validator() {
		return new ValuationDateValidator();
	}

	@Override
	public Validator<? super ValuationDate> typeFormatValidator() {
		return new ValuationDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationDate, Set<String>> onlyExistsValidator() {
		return new ValuationDateOnlyExistsValidator();
	}
}
