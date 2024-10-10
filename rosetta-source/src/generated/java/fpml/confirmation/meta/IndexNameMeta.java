package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IndexName;
import fpml.confirmation.validation.IndexNameTypeFormatValidator;
import fpml.confirmation.validation.IndexNameValidator;
import fpml.confirmation.validation.exists.IndexNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=IndexName.class)
public class IndexNameMeta implements RosettaMetaData<IndexName> {

	@Override
	public List<Validator<? super IndexName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndexName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IndexName> validator() {
		return new IndexNameValidator();
	}

	@Override
	public Validator<? super IndexName> typeFormatValidator() {
		return new IndexNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexName, Set<String>> onlyExistsValidator() {
		return new IndexNameOnlyExistsValidator();
	}
}
