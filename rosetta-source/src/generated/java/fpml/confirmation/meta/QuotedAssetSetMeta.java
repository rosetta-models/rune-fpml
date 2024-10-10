package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.QuotedAssetSet;
import fpml.confirmation.validation.QuotedAssetSetTypeFormatValidator;
import fpml.confirmation.validation.QuotedAssetSetValidator;
import fpml.confirmation.validation.exists.QuotedAssetSetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=QuotedAssetSet.class)
public class QuotedAssetSetMeta implements RosettaMetaData<QuotedAssetSet> {

	@Override
	public List<Validator<? super QuotedAssetSet>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QuotedAssetSet, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super QuotedAssetSet> validator() {
		return new QuotedAssetSetValidator();
	}

	@Override
	public Validator<? super QuotedAssetSet> typeFormatValidator() {
		return new QuotedAssetSetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuotedAssetSet, Set<String>> onlyExistsValidator() {
		return new QuotedAssetSetOnlyExistsValidator();
	}
}
