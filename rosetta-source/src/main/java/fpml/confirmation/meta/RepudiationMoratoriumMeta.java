package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RepudiationMoratorium;
import fpml.confirmation.validation.RepudiationMoratoriumTypeFormatValidator;
import fpml.confirmation.validation.RepudiationMoratoriumValidator;
import fpml.confirmation.validation.exists.RepudiationMoratoriumOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RepudiationMoratorium.class)
public class RepudiationMoratoriumMeta implements RosettaMetaData<RepudiationMoratorium> {

	@Override
	public List<Validator<? super RepudiationMoratorium>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RepudiationMoratorium, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RepudiationMoratorium> validator() {
		return new RepudiationMoratoriumValidator();
	}

	@Override
	public Validator<? super RepudiationMoratorium> typeFormatValidator() {
		return new RepudiationMoratoriumTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RepudiationMoratorium, Set<String>> onlyExistsValidator() {
		return new RepudiationMoratoriumOnlyExistsValidator();
	}
}
