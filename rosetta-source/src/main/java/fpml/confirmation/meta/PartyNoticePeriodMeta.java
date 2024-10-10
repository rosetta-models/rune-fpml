package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyNoticePeriod;
import fpml.confirmation.validation.PartyNoticePeriodTypeFormatValidator;
import fpml.confirmation.validation.PartyNoticePeriodValidator;
import fpml.confirmation.validation.exists.PartyNoticePeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyNoticePeriod.class)
public class PartyNoticePeriodMeta implements RosettaMetaData<PartyNoticePeriod> {

	@Override
	public List<Validator<? super PartyNoticePeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyNoticePeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyNoticePeriod> validator() {
		return new PartyNoticePeriodValidator();
	}

	@Override
	public Validator<? super PartyNoticePeriod> typeFormatValidator() {
		return new PartyNoticePeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyNoticePeriod, Set<String>> onlyExistsValidator() {
		return new PartyNoticePeriodOnlyExistsValidator();
	}
}
