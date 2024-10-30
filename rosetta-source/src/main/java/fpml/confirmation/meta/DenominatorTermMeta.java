package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DenominatorTerm;
import fpml.confirmation.validation.DenominatorTermTypeFormatValidator;
import fpml.confirmation.validation.DenominatorTermValidator;
import fpml.confirmation.validation.exists.DenominatorTermOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DenominatorTerm.class)
public class DenominatorTermMeta implements RosettaMetaData<DenominatorTerm> {

	@Override
	public List<Validator<? super DenominatorTerm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DenominatorTerm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DenominatorTerm> validator() {
		return new DenominatorTermValidator();
	}

	@Override
	public Validator<? super DenominatorTerm> typeFormatValidator() {
		return new DenominatorTermTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DenominatorTerm, Set<String>> onlyExistsValidator() {
		return new DenominatorTermOnlyExistsValidator();
	}
}
