package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReferencePair;
import fpml.confirmation.validation.ReferencePairTypeFormatValidator;
import fpml.confirmation.validation.ReferencePairValidator;
import fpml.confirmation.validation.exists.ReferencePairOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReferencePair.class)
public class ReferencePairMeta implements RosettaMetaData<ReferencePair> {

	@Override
	public List<Validator<? super ReferencePair>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ReferencePair>create(fpml.confirmation.validation.datarule.ReferencePairChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReferencePair, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReferencePair> validator() {
		return new ReferencePairValidator();
	}

	@Override
	public Validator<? super ReferencePair> typeFormatValidator() {
		return new ReferencePairTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferencePair, Set<String>> onlyExistsValidator() {
		return new ReferencePairOnlyExistsValidator();
	}
}
