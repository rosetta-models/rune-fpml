package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IndexAnnexSource;
import fpml.confirmation.validation.IndexAnnexSourceTypeFormatValidator;
import fpml.confirmation.validation.IndexAnnexSourceValidator;
import fpml.confirmation.validation.exists.IndexAnnexSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=IndexAnnexSource.class)
public class IndexAnnexSourceMeta implements RosettaMetaData<IndexAnnexSource> {

	@Override
	public List<Validator<? super IndexAnnexSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndexAnnexSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IndexAnnexSource> validator() {
		return new IndexAnnexSourceValidator();
	}

	@Override
	public Validator<? super IndexAnnexSource> typeFormatValidator() {
		return new IndexAnnexSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexAnnexSource, Set<String>> onlyExistsValidator() {
		return new IndexAnnexSourceOnlyExistsValidator();
	}
}
