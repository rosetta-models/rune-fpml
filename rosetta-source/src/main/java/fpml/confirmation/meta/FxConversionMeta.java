package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxConversion;
import fpml.confirmation.validation.FxConversionTypeFormatValidator;
import fpml.confirmation.validation.FxConversionValidator;
import fpml.confirmation.validation.exists.FxConversionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxConversion.class)
public class FxConversionMeta implements RosettaMetaData<FxConversion> {

	@Override
	public List<Validator<? super FxConversion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxConversion>create(fpml.confirmation.validation.datarule.FxConversionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxConversion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxConversion> validator() {
		return new FxConversionValidator();
	}

	@Override
	public Validator<? super FxConversion> typeFormatValidator() {
		return new FxConversionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxConversion, Set<String>> onlyExistsValidator() {
		return new FxConversionOnlyExistsValidator();
	}
}
