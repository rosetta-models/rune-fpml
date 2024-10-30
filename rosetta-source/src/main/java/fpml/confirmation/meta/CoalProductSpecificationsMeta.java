package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalProductSpecifications;
import fpml.confirmation.validation.CoalProductSpecificationsTypeFormatValidator;
import fpml.confirmation.validation.CoalProductSpecificationsValidator;
import fpml.confirmation.validation.exists.CoalProductSpecificationsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CoalProductSpecifications.class)
public class CoalProductSpecificationsMeta implements RosettaMetaData<CoalProductSpecifications> {

	@Override
	public List<Validator<? super CoalProductSpecifications>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CoalProductSpecifications>create(fpml.confirmation.validation.datarule.CoalProductSpecificationsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CoalProductSpecifications, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalProductSpecifications> validator() {
		return new CoalProductSpecificationsValidator();
	}

	@Override
	public Validator<? super CoalProductSpecifications> typeFormatValidator() {
		return new CoalProductSpecificationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalProductSpecifications, Set<String>> onlyExistsValidator() {
		return new CoalProductSpecificationsOnlyExistsValidator();
	}
}
