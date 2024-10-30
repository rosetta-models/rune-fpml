package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RelatedBusinessUnit;
import fpml.confirmation.validation.RelatedBusinessUnitTypeFormatValidator;
import fpml.confirmation.validation.RelatedBusinessUnitValidator;
import fpml.confirmation.validation.exists.RelatedBusinessUnitOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RelatedBusinessUnit.class)
public class RelatedBusinessUnitMeta implements RosettaMetaData<RelatedBusinessUnit> {

	@Override
	public List<Validator<? super RelatedBusinessUnit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RelatedBusinessUnit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RelatedBusinessUnit> validator() {
		return new RelatedBusinessUnitValidator();
	}

	@Override
	public Validator<? super RelatedBusinessUnit> typeFormatValidator() {
		return new RelatedBusinessUnitTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelatedBusinessUnit, Set<String>> onlyExistsValidator() {
		return new RelatedBusinessUnitOnlyExistsValidator();
	}
}
