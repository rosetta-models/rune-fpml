package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UnderlyerInterestLeg;
import fpml.confirmation.validation.UnderlyerInterestLegTypeFormatValidator;
import fpml.confirmation.validation.UnderlyerInterestLegValidator;
import fpml.confirmation.validation.exists.UnderlyerInterestLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=UnderlyerInterestLeg.class)
public class UnderlyerInterestLegMeta implements RosettaMetaData<UnderlyerInterestLeg> {

	@Override
	public List<Validator<? super UnderlyerInterestLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.UnderlyerInterestLeg>create(fpml.confirmation.validation.datarule.UnderlyerInterestLegChoice.class)
		);
	}
	
	@Override
	public List<Function<? super UnderlyerInterestLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UnderlyerInterestLeg> validator() {
		return new UnderlyerInterestLegValidator();
	}

	@Override
	public Validator<? super UnderlyerInterestLeg> typeFormatValidator() {
		return new UnderlyerInterestLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnderlyerInterestLeg, Set<String>> onlyExistsValidator() {
		return new UnderlyerInterestLegOnlyExistsValidator();
	}
}
