package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalAttributeDecimal;
import fpml.confirmation.validation.CoalAttributeDecimalTypeFormatValidator;
import fpml.confirmation.validation.CoalAttributeDecimalValidator;
import fpml.confirmation.validation.exists.CoalAttributeDecimalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CoalAttributeDecimal.class)
public class CoalAttributeDecimalMeta implements RosettaMetaData<CoalAttributeDecimal> {

	@Override
	public List<Validator<? super CoalAttributeDecimal>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CoalAttributeDecimal>create(fpml.confirmation.validation.datarule.CoalAttributeDecimalChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CoalAttributeDecimal, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalAttributeDecimal> validator() {
		return new CoalAttributeDecimalValidator();
	}

	@Override
	public Validator<? super CoalAttributeDecimal> typeFormatValidator() {
		return new CoalAttributeDecimalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalAttributeDecimal, Set<String>> onlyExistsValidator() {
		return new CoalAttributeDecimalOnlyExistsValidator();
	}
}
