package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IndexChange;
import fpml.confirmation.validation.IndexChangeTypeFormatValidator;
import fpml.confirmation.validation.IndexChangeValidator;
import fpml.confirmation.validation.exists.IndexChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=IndexChange.class)
public class IndexChangeMeta implements RosettaMetaData<IndexChange> {

	@Override
	public List<Validator<? super IndexChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndexChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IndexChange> validator() {
		return new IndexChangeValidator();
	}

	@Override
	public Validator<? super IndexChange> typeFormatValidator() {
		return new IndexChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexChange, Set<String>> onlyExistsValidator() {
		return new IndexChangeOnlyExistsValidator();
	}
}
