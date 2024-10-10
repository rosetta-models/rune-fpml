package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FallbackReferencePriceType;
import fpml.confirmation.validation.FallbackReferencePriceTypeTypeFormatValidator;
import fpml.confirmation.validation.FallbackReferencePriceTypeValidator;
import fpml.confirmation.validation.exists.FallbackReferencePriceTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FallbackReferencePriceType.class)
public class FallbackReferencePriceTypeMeta implements RosettaMetaData<FallbackReferencePriceType> {

	@Override
	public List<Validator<? super FallbackReferencePriceType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FallbackReferencePriceType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FallbackReferencePriceType> validator() {
		return new FallbackReferencePriceTypeValidator();
	}

	@Override
	public Validator<? super FallbackReferencePriceType> typeFormatValidator() {
		return new FallbackReferencePriceTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FallbackReferencePriceType, Set<String>> onlyExistsValidator() {
		return new FallbackReferencePriceTypeOnlyExistsValidator();
	}
}
