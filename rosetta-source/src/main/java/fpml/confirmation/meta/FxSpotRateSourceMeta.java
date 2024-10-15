package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxSpotRateSource;
import fpml.confirmation.validation.FxSpotRateSourceTypeFormatValidator;
import fpml.confirmation.validation.FxSpotRateSourceValidator;
import fpml.confirmation.validation.exists.FxSpotRateSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxSpotRateSource.class)
public class FxSpotRateSourceMeta implements RosettaMetaData<FxSpotRateSource> {

	@Override
	public List<Validator<? super FxSpotRateSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxSpotRateSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxSpotRateSource> validator() {
		return new FxSpotRateSourceValidator();
	}

	@Override
	public Validator<? super FxSpotRateSource> typeFormatValidator() {
		return new FxSpotRateSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSpotRateSource, Set<String>> onlyExistsValidator() {
		return new FxSpotRateSourceOnlyExistsValidator();
	}
}
