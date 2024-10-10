package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RateSourcePage;
import fpml.confirmation.validation.RateSourcePageTypeFormatValidator;
import fpml.confirmation.validation.RateSourcePageValidator;
import fpml.confirmation.validation.exists.RateSourcePageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RateSourcePage.class)
public class RateSourcePageMeta implements RosettaMetaData<RateSourcePage> {

	@Override
	public List<Validator<? super RateSourcePage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RateSourcePage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RateSourcePage> validator() {
		return new RateSourcePageValidator();
	}

	@Override
	public Validator<? super RateSourcePage> typeFormatValidator() {
		return new RateSourcePageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RateSourcePage, Set<String>> onlyExistsValidator() {
		return new RateSourcePageOnlyExistsValidator();
	}
}
