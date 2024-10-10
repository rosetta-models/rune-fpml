package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditLimitUtilizationPosition;
import fpml.confirmation.validation.CreditLimitUtilizationPositionTypeFormatValidator;
import fpml.confirmation.validation.CreditLimitUtilizationPositionValidator;
import fpml.confirmation.validation.exists.CreditLimitUtilizationPositionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CreditLimitUtilizationPosition.class)
public class CreditLimitUtilizationPositionMeta implements RosettaMetaData<CreditLimitUtilizationPosition> {

	@Override
	public List<Validator<? super CreditLimitUtilizationPosition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CreditLimitUtilizationPosition>create(fpml.confirmation.validation.datarule.CreditLimitUtilizationPositionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CreditLimitUtilizationPosition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditLimitUtilizationPosition> validator() {
		return new CreditLimitUtilizationPositionValidator();
	}

	@Override
	public Validator<? super CreditLimitUtilizationPosition> typeFormatValidator() {
		return new CreditLimitUtilizationPositionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditLimitUtilizationPosition, Set<String>> onlyExistsValidator() {
		return new CreditLimitUtilizationPositionOnlyExistsValidator();
	}
}
