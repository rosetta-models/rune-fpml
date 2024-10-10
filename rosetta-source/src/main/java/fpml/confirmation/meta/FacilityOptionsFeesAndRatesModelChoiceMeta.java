package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityOptionsFeesAndRatesModelChoice;
import fpml.confirmation.validation.FacilityOptionsFeesAndRatesModelChoiceTypeFormatValidator;
import fpml.confirmation.validation.FacilityOptionsFeesAndRatesModelChoiceValidator;
import fpml.confirmation.validation.exists.FacilityOptionsFeesAndRatesModelChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityOptionsFeesAndRatesModelChoice.class)
public class FacilityOptionsFeesAndRatesModelChoiceMeta implements RosettaMetaData<FacilityOptionsFeesAndRatesModelChoice> {

	@Override
	public List<Validator<? super FacilityOptionsFeesAndRatesModelChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FacilityOptionsFeesAndRatesModelChoice>create(fpml.confirmation.validation.datarule.FacilityOptionsFeesAndRatesModelChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FacilityOptionsFeesAndRatesModelChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityOptionsFeesAndRatesModelChoice> validator() {
		return new FacilityOptionsFeesAndRatesModelChoiceValidator();
	}

	@Override
	public Validator<? super FacilityOptionsFeesAndRatesModelChoice> typeFormatValidator() {
		return new FacilityOptionsFeesAndRatesModelChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityOptionsFeesAndRatesModelChoice, Set<String>> onlyExistsValidator() {
		return new FacilityOptionsFeesAndRatesModelChoiceOnlyExistsValidator();
	}
}
