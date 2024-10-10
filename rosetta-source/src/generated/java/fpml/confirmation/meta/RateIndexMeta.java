package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RateIndex;
import fpml.confirmation.validation.RateIndexTypeFormatValidator;
import fpml.confirmation.validation.RateIndexValidator;
import fpml.confirmation.validation.exists.RateIndexOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RateIndex.class)
public class RateIndexMeta implements RosettaMetaData<RateIndex> {

	@Override
	public List<Validator<? super RateIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RateIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RateIndex> validator() {
		return new RateIndexValidator();
	}

	@Override
	public Validator<? super RateIndex> typeFormatValidator() {
		return new RateIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RateIndex, Set<String>> onlyExistsValidator() {
		return new RateIndexOnlyExistsValidator();
	}
}
