package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DeClear;
import fpml.confirmation.validation.DeClearTypeFormatValidator;
import fpml.confirmation.validation.DeClearValidator;
import fpml.confirmation.validation.exists.DeClearOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DeClear.class)
public class DeClearMeta implements RosettaMetaData<DeClear> {

	@Override
	public List<Validator<? super DeClear>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DeClear, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DeClear> validator() {
		return new DeClearValidator();
	}

	@Override
	public Validator<? super DeClear> typeFormatValidator() {
		return new DeClearTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeClear, Set<String>> onlyExistsValidator() {
		return new DeClearOnlyExistsValidator();
	}
}
