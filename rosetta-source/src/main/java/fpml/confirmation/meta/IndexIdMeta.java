package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IndexId;
import fpml.confirmation.validation.IndexIdTypeFormatValidator;
import fpml.confirmation.validation.IndexIdValidator;
import fpml.confirmation.validation.exists.IndexIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=IndexId.class)
public class IndexIdMeta implements RosettaMetaData<IndexId> {

	@Override
	public List<Validator<? super IndexId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndexId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IndexId> validator() {
		return new IndexIdValidator();
	}

	@Override
	public Validator<? super IndexId> typeFormatValidator() {
		return new IndexIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexId, Set<String>> onlyExistsValidator() {
		return new IndexIdOnlyExistsValidator();
	}
}
