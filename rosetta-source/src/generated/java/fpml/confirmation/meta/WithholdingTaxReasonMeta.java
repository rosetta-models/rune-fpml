package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WithholdingTaxReason;
import fpml.confirmation.validation.WithholdingTaxReasonTypeFormatValidator;
import fpml.confirmation.validation.WithholdingTaxReasonValidator;
import fpml.confirmation.validation.exists.WithholdingTaxReasonOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=WithholdingTaxReason.class)
public class WithholdingTaxReasonMeta implements RosettaMetaData<WithholdingTaxReason> {

	@Override
	public List<Validator<? super WithholdingTaxReason>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WithholdingTaxReason, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WithholdingTaxReason> validator() {
		return new WithholdingTaxReasonValidator();
	}

	@Override
	public Validator<? super WithholdingTaxReason> typeFormatValidator() {
		return new WithholdingTaxReasonTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WithholdingTaxReason, Set<String>> onlyExistsValidator() {
		return new WithholdingTaxReasonOnlyExistsValidator();
	}
}
