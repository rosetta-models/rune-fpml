package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalAttributePercentage;
import fpml.confirmation.validation.CoalAttributePercentageTypeFormatValidator;
import fpml.confirmation.validation.CoalAttributePercentageValidator;
import fpml.confirmation.validation.exists.CoalAttributePercentageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CoalAttributePercentage.class)
public class CoalAttributePercentageMeta implements RosettaMetaData<CoalAttributePercentage> {

	@Override
	public List<Validator<? super CoalAttributePercentage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CoalAttributePercentage>create(fpml.confirmation.validation.datarule.CoalAttributePercentageChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CoalAttributePercentage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalAttributePercentage> validator() {
		return new CoalAttributePercentageValidator();
	}

	@Override
	public Validator<? super CoalAttributePercentage> typeFormatValidator() {
		return new CoalAttributePercentageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalAttributePercentage, Set<String>> onlyExistsValidator() {
		return new CoalAttributePercentageOnlyExistsValidator();
	}
}
