package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ObligationDefault;
import fpml.confirmation.validation.ObligationDefaultTypeFormatValidator;
import fpml.confirmation.validation.ObligationDefaultValidator;
import fpml.confirmation.validation.exists.ObligationDefaultOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ObligationDefault.class)
public class ObligationDefaultMeta implements RosettaMetaData<ObligationDefault> {

	@Override
	public List<Validator<? super ObligationDefault>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObligationDefault, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ObligationDefault> validator() {
		return new ObligationDefaultValidator();
	}

	@Override
	public Validator<? super ObligationDefault> typeFormatValidator() {
		return new ObligationDefaultTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObligationDefault, Set<String>> onlyExistsValidator() {
		return new ObligationDefaultOnlyExistsValidator();
	}
}
