package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyGroupType;
import fpml.confirmation.validation.PartyGroupTypeTypeFormatValidator;
import fpml.confirmation.validation.PartyGroupTypeValidator;
import fpml.confirmation.validation.exists.PartyGroupTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PartyGroupType.class)
public class PartyGroupTypeMeta implements RosettaMetaData<PartyGroupType> {

	@Override
	public List<Validator<? super PartyGroupType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyGroupType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyGroupType> validator() {
		return new PartyGroupTypeValidator();
	}

	@Override
	public Validator<? super PartyGroupType> typeFormatValidator() {
		return new PartyGroupTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyGroupType, Set<String>> onlyExistsValidator() {
		return new PartyGroupTypeOnlyExistsValidator();
	}
}
