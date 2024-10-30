package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LcRenewal;
import fpml.confirmation.validation.LcRenewalTypeFormatValidator;
import fpml.confirmation.validation.LcRenewalValidator;
import fpml.confirmation.validation.exists.LcRenewalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LcRenewal.class)
public class LcRenewalMeta implements RosettaMetaData<LcRenewal> {

	@Override
	public List<Validator<? super LcRenewal>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcRenewal, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LcRenewal> validator() {
		return new LcRenewalValidator();
	}

	@Override
	public Validator<? super LcRenewal> typeFormatValidator() {
		return new LcRenewalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcRenewal, Set<String>> onlyExistsValidator() {
		return new LcRenewalOnlyExistsValidator();
	}
}
